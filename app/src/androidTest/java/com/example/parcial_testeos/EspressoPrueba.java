package com.example.parcial_testeos;

import static org.hamcrest.MatcherAssert.assertThat;

import android.content.ComponentName;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.example.parcial_testeos.MainActivity;
import com.example.parcial_testeos.R;
import com.example.parcial_testeos.Registros;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest
public class EspressoPrueba {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testLoginSuccess() {
        // Introducir el usuario y contraseña correctos
        Espresso.onView(ViewMatchers.withId(R.id.nombreEdit)).perform(ViewActions.typeText("usma202528"));
        Espresso.onView(ViewMatchers.withId(R.id.passwordEdit)).perform(ViewActions.typeText("181019"));
        Espresso.closeSoftKeyboard();

        // Presionar el botón de ingresar
        Espresso.onView(ViewMatchers.withId(R.id.btn_ingresar)).perform(ViewActions.click());

        // Verificar que se haya iniciado la actividad Registros
        ActivityScenario<Registros> scenario = ActivityScenario.launch(Registros.class);
        scenario.onActivity(activity -> assertThat(activity.getComponentName(), Matchers.equalTo(new ComponentName(activity, Registros.class))));
    }

    @Test
    public void testLoginFail() {
        // Introducir un usuario o contraseña incorrectos
        Espresso.onView(ViewMatchers.withId(R.id.nombreEdit)).perform(ViewActions.typeText("usuario_invalido"));
        Espresso.onView(ViewMatchers.withId(R.id.passwordEdit)).perform(ViewActions.typeText("contraseña_invalida"));
        Espresso.closeSoftKeyboard();

        // Presionar el botón de ingresar
        Espresso.onView(ViewMatchers.withId(R.id.btn_ingresar)).perform(ViewActions.click());

        // Verificar que se muestre un mensaje de error
        Espresso.onView(ViewMatchers.withText("Nombre de usuario o contraseña incorrectos")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }
}
