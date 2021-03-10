package com.im.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @author zhaojinhui
 * @date 2021/2/28 17:00
 * @apiNote
 */

public class SecurityUser extends org.springframework.security.core.userdetails.User implements UserDetails {

    private transient  ImUser currentUserInfo;

    private List<String> permissionList;

    private String username;

    private String password;

    private Collection<? extends GrantedAuthority> authorities;


    public SecurityUser(String username, String password,
                Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }


    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public ImUser getCurrentUserInfo() {
        return currentUserInfo;
    }

    public void setCurrentUserInfo(ImUser currentUserInfo) {
        this.currentUserInfo = currentUserInfo;
    }

    public List<String> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<String> permissionList) {
        this.permissionList = permissionList;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
