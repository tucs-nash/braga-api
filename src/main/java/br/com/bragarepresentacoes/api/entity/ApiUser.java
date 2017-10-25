package br.com.bragarepresentacoes.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "USERS")
@Data
public class ApiUser {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "LOGIN")
    private String login;
    
    @Column(name = "PASSWORD")
    private String password;            
    
    @Column(name = "PERMISSION_LEVEL")
    @Enumerated(EnumType.ORDINAL)
    private PermissionLevel permissionLevel;
}
