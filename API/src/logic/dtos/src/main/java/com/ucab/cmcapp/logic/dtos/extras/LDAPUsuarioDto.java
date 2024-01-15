package com.ucab.cmcapp.logic.dtos.extras;


import java.util.Properties;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.*;

public class LDAPUsuarioDto {

    private static DirContext connection;

    public LDAPUsuarioDto() {
        newConnection();
    }

    /* create connection during object creation */
    public void newConnection() {
        Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:10389");
        env.put(Context.SECURITY_PRINCIPAL, "uid=admin, ou=system");
        env.put(Context.SECURITY_CREDENTIALS, "secret");
        try {
            connection = new InitialDirContext(env);
            System.out.println("La conexion con LDAP se hizo correctamente");
        } catch (AuthenticationException ex) {
            System.out.println("No se pudo establecer la conexion con LDAP");
            System.out.println(ex.getMessage());
        } catch (NamingException e) {
            System.out.println("No se pudo establecer la conexion con LDAP");
            e.printStackTrace();
        }
    }

    public static void agregarUsuario(String alias, String clave) {
        Attributes attributes = new BasicAttributes();
        Attribute attribute = new BasicAttribute("objectClass");
        attribute.add("inetOrgPerson");

        attributes.put(attribute);
        // user details
        attributes.put("sn", alias);
        attributes.put("userPassword", clave);
        try {
            connection.createSubcontext("cn=" + alias + ",ou=usuario,ou=system", attributes);
            System.out.println("El usuario: " + alias + " se agrego correctamente");
        } catch (NamingException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
        }

    }

    public void eliminarUsuario(String alias) {
        try {
            connection.destroySubcontext("cn=" + alias + ",ou=usuario,ou=system");
            System.out.println("El usuario " + alias + " se ha eliminado correctamente");
        } catch (NamingException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
        }
    }

    public static boolean autenticarUsuario(String alias, String clave) {
        try {
            Properties env = new Properties();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL, "ldap://localhost:10389");
            env.put(Context.SECURITY_PRINCIPAL, "cn=" + alias + ",ou=usuario,ou=system"); // check the DN correctly
            env.put(Context.SECURITY_CREDENTIALS, clave);
            DirContext con = new InitialDirContext(env);
            System.out.println("El usuario " + alias + " se autentico correctamente");
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public void actualizarClaveUsuario(String alias, String clave) {
        try {
            String dnBase = ",ou=usuario,ou=system";
            ModificationItem[] mods = new ModificationItem[1];
            mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, new BasicAttribute("userPassword", clave));
            connection.modifyAttributes("cn=" + alias + dnBase, mods);
            System.out.println("Se cambio la clave del usuario " + alias + " correctamente");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        boolean borrar = true;
        boolean agregar = false;

        try {
            LDAPUsuarioDto app = new LDAPUsuarioDto();

            if (agregar) {
                app.agregarUsuario("hola", "hola");
            }

            if (borrar) {
                app.eliminarUsuario("jesumanu");
                app.eliminarUsuario("hola");
                app.eliminarUsuario("kate");
                app.eliminarUsuario("pedrito3");
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

}

