package com.itacadam.myapp.infrastructure.persistence.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserEntityTest {

    @Test
    void testNoArgsConstructor() {
        UserEntity user = new UserEntity();
        assertNull(user.getId());
        assertNull(user.getNombre());
        assertNull(user.getContrasena());
        assertEquals(0, user.getEdad());
        assertFalse(user.isAdministrador());
    }

    @Test
    void testAllArgsConstructor() {
        UserEntity user = new UserEntity(1L, "Juan", "password123", 25, true, "ADMIN");
        assertEquals(1L, user.getId());
        assertEquals("Juan", user.getNombre());
        assertEquals("password123", user.getContrasena());
        assertEquals(25, user.getEdad());
        assertTrue(user.isAdministrador());
    }

    @Test
    void testSettersAndGetters() {
        UserEntity user = new UserEntity();
        user.setId(2L);
        user.setNombre("Maria");
        user.setContrasena("secure456");
        user.setEdad(30);
        user.setAdministrador(false);

        assertEquals(2L, user.getId());
        assertEquals("Maria", user.getNombre());
        assertEquals("secure456", user.getContrasena());
        assertEquals(30, user.getEdad());
        assertFalse(user.isAdministrador());
    }

    @Test
    void testAdministradorFlag() {
        UserEntity adminUser = new UserEntity(1L, "Admin", "pass", 40, true, "ADMIN");
        assertTrue(adminUser.isAdministrador());

        UserEntity regularUser = new UserEntity(2L, "User", "pass", 25, false, "USER");
        assertFalse(regularUser.isAdministrador());
    }
}