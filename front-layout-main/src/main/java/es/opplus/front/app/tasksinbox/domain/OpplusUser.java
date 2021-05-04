package es.opplus.front.app.tasksinbox.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class OpplusUser implements Serializable {
    private static final long serialVersionUID = -8271072045588680613L;

    public static final String DEFAULT_MAIN_ROLE = "ROLE_AGENT";
    public static final String AGENT_ROLE = "ROLE_AGENT";
    public static final String EXPERT_ROLE = "ROLE_EXPERT";
    public static final String ADMIN_ROLE = "ROLE_ADMIN";
    public static final String MANAGER_ROLE = "ROLE_MANAGER";
    protected static final List<String> EXPERT_MANAGER_ADMIN_ROLES = Arrays.asList(MANAGER_ROLE, EXPERT_ROLE, ADMIN_ROLE);

    public static final String ROLE_SEPARATOR = ",";

    private String username;
    private String roles;
    private String name;
    private String userid;

    public OpplusUser() {
        super();
    }

    public OpplusUser(String username, String roles) {
        super();
        this.username = username;
        this.roles = roles;
    }

    public OpplusUser(String username, String roles, String name) {
        this(username, roles);

        this.name = name;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "OpplusUser [username=" + username + ", roles=" + roles + ", name=" + name + ", userid="
                + userid + "]";
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Collection<String> getAuthorities() {

        if (this.roles == null) return new ArrayList<String>();

        String[] roleArray = this.roles.split(ROLE_SEPARATOR);

        Collection<String> result = new ArrayList<String>();
        for (int i = 0; i < roleArray.length; i++) {
            String rol = roleArray[i];
            if (rol == null) continue;
            if (rol.length() == 0) continue;
            result.add(rol.trim());
        }

        return result;

    }


}