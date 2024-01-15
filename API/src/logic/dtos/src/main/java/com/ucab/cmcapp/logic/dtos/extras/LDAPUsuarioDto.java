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


    /**
     * Crea una nueva conexión con el servidor LDAP utilizando las propiedades de configuración predefinidas.
     */
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

    /**
     * Agrega un nuevo usuario al servidor LDAP con el alias y la clave especificados.
     *
     * @param alias El alias del usuario.
     * @param clave La clave del usuario.
     */
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

    /**
     * Elimina un usuario existente del servidor LDAP.
     *
     * @param alias El alias del usuario a eliminar.
     */
    public void eliminarUsuario(String alias) {
        try {
            connection.destroySubcontext("cn=" + alias + ",ou=usuario,ou=system");
            System.out.println("El usuario " + alias + " se ha eliminado correctamente");
        } catch (NamingException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
        }
    }

    /**
     * Autentica a un usuario en el servidor LDAP utilizando el alias y la clave especificados.
     *
     * @param alias El alias del usuario.
     * @param clave La clave del usuario.
     * @return `true` si la autenticación es exitosa, `false` en caso contrario.
     */
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

    /**
     * Actualiza la clave de un usuario existente en el servidor LDAP.
     *
     * @param alias El alias del usuario.
     * @param clave La nueva clave del usuario.
     */
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
}

