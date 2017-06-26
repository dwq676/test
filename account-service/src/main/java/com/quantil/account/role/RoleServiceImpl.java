package com.quantil.account.role;

import com.zoe.snow.crud.CrudService;
import com.zoe.snow.model.support.user.role.BasePermissionSupport;
import com.zoe.snow.model.support.user.role.BaseRoleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * RoleServiceImpl
 *
 * @author <a href="mailto:dwq676@126.com">daiwenqing</a>
 * @date 2017/6/15
 */
@Service("account.role.service")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private CrudService crudService;

    @Override
    public Set<BasePermissionSupport> findPermissions(String roleId) {
        return null;
    }

    @Override
    public BaseRoleModel findRole(String accountId) {
        Account2RoleModel account2RoleModel = crudService.query().from(Account2RoleModel.class)
                .where("accountId", accountId).one();
        if (account2RoleModel != null) {
            return crudService.query().from(RoleModel.class)
                    .where("id", account2RoleModel.getRoleId()).one();
        }
        return null;
    }

}
