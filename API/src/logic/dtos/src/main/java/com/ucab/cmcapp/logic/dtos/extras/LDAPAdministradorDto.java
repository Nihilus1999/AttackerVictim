package com.ucab.cmcapp.logic.dtos.extras;

import java.util.Properties;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.*;

public class LDAPAdministradorDto {

private DirContext connection;

public LDAPAdministradorDto() {
    newConnection();
}


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

    public void agregarAdministrator(String alias, String clave) {
        Attributes attributes = new BasicAttributes();
        Attribute attribute = new BasicAttribute("objectClass");
        attribute.add("inetOrgPerson");

        attributes.put(attribute);
        attributes.put("sn", alias);
        attributes.put("userPassword", clave);
        try {
            connection.createSubcontext("cn=" + alias + ",ou=administrador,ou=system", attributes);
            System.out.println("El administrador " + alias + " se agrego correctamente:");
        } catch (NamingException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
        }

    }

    public void eliminarAdministrator(String alias) {
        try {
            connection.destroySubcontext("cn=" + alias + ",ou=administrador,ou=system");
            System.out.println("El administrador " + alias + " se ha eliminado correctamente:");
        } catch (NamingException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
        }
    }

    public static boolean autenticarAdministrator(String alias, String clave) {
        try {
            Properties env = new Properties();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL, "ldap://localhost:10389");
            env.put(Context.SECURITY_PRINCIPAL, "cn=" + alias + ",ou=administrador,ou=system"); // check the DN correctly
            env.put(Context.SECURITY_CREDENTIALS, clave);
            DirContext con = new InitialDirContext(env);
            System.out.println("El administrador " + alias + " se autentico correctamente");
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public void actualizarClaveAdministrador(String alias, String clave) {
        try {
            String dnBase = ",ou=administrador,ou=system";
            ModificationItem[] mods = new ModificationItem[1];
            mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, new BasicAttribute("userPassword", clave));
            connection.modifyAttributes("cn=" + alias + dnBase, mods); // try to form DN dynamically
            System.out.println("Se cambio la clave del administrador " + alias + " correctamente");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
