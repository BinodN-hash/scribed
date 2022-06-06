package com.app.scribed;

import com.app.scribed.model.Group;
import com.app.scribed.model.Permission;
import com.app.scribed.model.enums.GroupType;
import com.app.scribed.model.enums.PermissionCategory;
import com.app.scribed.repository.GroupRepository;
import com.app.scribed.repository.PermissionRepository;
import com.app.scribed.repository.UserRepository;
import com.app.scribed.repository.VerificationTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final UserRepository userRepo;
    private final GroupRepository groupRepo;
    private final PermissionRepository permissionRepo;
    private final VerificationTokenRepository verificationTokenRepo;
    private final BCryptPasswordEncoder passwordEncoder;

    private boolean alreadySetup =false;

    @Override
    @Transactional
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        if (alreadySetup){
            return;
        }

    }


    @Transactional
    Permission createPrivilege(final String permissionCategory, final String name, final String code){
        Permission permission = permissionRepo.findByName(name);
        if (permission == null){
            permission = new Permission();
            permission.setName(name);
            permission.setCode(code);
            permission.setCategory(PermissionCategory.valueOf(permissionCategory));
            permission = permissionRepo.save(permission);

        }
        return permission;

    }

    @Transactional
    Group createGroup(final GroupType code, final String name, final Set<Permission> permissions){
        Group group = groupRepo.findByName(name);
        if (group == null){
            group = new Group();
            group.setName(name);
            group.setCode(code);

        }
        group.setPermissions(permissions);
        group = groupRepo.save(group);
        return group;

    }

}
