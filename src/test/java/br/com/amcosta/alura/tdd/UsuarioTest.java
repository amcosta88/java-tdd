package br.com.amcosta.alura.tdd;

import org.junit.Assert;
import org.junit.Test;

public class UsuarioTest {

    @Test
    public void testAtributos()
    {
        Usuario usuario = new Usuario(1, "Alex Moreno");
        Assert.assertEquals(1, usuario.getId());
        Assert.assertEquals("Alex Moreno", usuario.getNome());
    }
}
