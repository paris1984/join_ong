package es.pjd.data.model;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserTest {

    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String NICK = "nick";
    private static final String PHONE = "phone";
    private static final String EMAIL = "email";
    private static final String UID = "uid";

    @Test
    public void userShouldBeWellBuilt(){
        Map<String, Permission> organizationPermissions = buildPermissionsMap();
        User user = new User(UID, NAME, SURNAME, NICK, PHONE, EMAIL, organizationPermissions);

        assertThat(NAME, is(user.getName()));
        assertThat(SURNAME, is(user.getSurname()));
        assertThat(NICK, is(user.getNick()));
        assertThat(PHONE, is(user.getPhone()));
        assertThat(EMAIL, is(user.getEmail()));
        assertThat(UID, is(user.getUid()));
        assertThat(2, is(user.getOrganizacionPermissions().size()));
        assertThat(Permission.ADMIN.getPermission(), is(user.getOrganizacionPermissions().get("ORG_1").getPermission()));
        assertThat(Permission.VOLUNTEER.getPermission(), is(user.getOrganizacionPermissions().get("ORG_2").getPermission()));
    }

    private Map<String, Permission> buildPermissionsMap(){
        Map<String, Permission> organizationPermissions = new HashMap<>();
        organizationPermissions.put("ORG_1", Permission.ADMIN);
        organizationPermissions.put("ORG_2", Permission.VOLUNTEER);
        return organizationPermissions;
    }
}
