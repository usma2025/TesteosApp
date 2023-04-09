package com.example.parcial_testeos;

import android.os.Looper;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RegistrosTest extends TestCase {
    private Registros registros;
    @Before
    public void SetUp(){
        registros = new Registros();
    }
    @After
    public void tearDown(){
        registros = null;
    }

    @Test
    public void testCalcularFactorial() {
        int resultado = Registros.calcularFactorial(5);
        assertEquals(120, resultado);
    }
    @Test
    public void testCalcularFactorial2() {
        int resultado = Registros.calcularFactorial(3);
        assertEquals(6, resultado);
    }

    /*public void testCalcularFactorial2() {
        int resultado = Registros.calcularFactorial(5);
        assertEquals(121, resultado);
    }*/

    /*private Registros mActivity;
    @Before
    protected void setUp() throws Exception {
        mActivity = new Registros();
        Looper.prepare();
    }

    @After
    protected void tearDown() throws Exception {
        mActivity.finish();
    }

    @Test
    public void testCalcularFactorial() {
        int edad = 5;
        int factorial = mActivity.calcularFactorial(edad);
        assertEquals(120, factorial);
    }*/
}