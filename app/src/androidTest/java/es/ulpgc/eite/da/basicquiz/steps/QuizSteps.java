package es.ulpgc.eite.da.basicquiz.steps;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

import androidx.test.core.app.ActivityScenario;

import es.ulpgc.eite.da.basicquiz.QuestionActivity;
import es.ulpgc.eite.da.basicquiz.R;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

// Project: Basic Quiz
// Created by Luis Hernandez on 10/6/24.
// Copyright (c) 2024 EITE (ULPGC).
public class QuizSteps {

    ActivityScenario<QuestionActivity> scenario =
        ActivityScenario.launch(QuestionActivity.class);

    @Given("iniciar pantalla Question")
    public void iniciarPantallaQuestion() {

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
    }

    @And("mostrar pregunta {string}")
    public void mostrarPregunta(String question) {
        onView(withId(R.id.questionField)).check(matches(withText(question)));
    }

    @And("ocultar resultado")
    public void ocultarResultado() {
        onView(withId(R.id.resultField)).check(matches(withText("???")));
    }

    @And("mostrar botones True y False y Cheat activados")
    public void mostrarBotonesTrueYFalseYCheatActivados() {
        onView(withId(R.id.trueButton)).check(matches(isEnabled()));
        onView(withId(R.id.falseButton)).check(matches(isEnabled()));
        onView(withId(R.id.cheatButton)).check(matches(isEnabled()));
    }


    @And("mostrar boton Next desactivado")
    public void mostrarBotonNextDesactivado() {
        onView(withId(R.id.nextButton)).check(matches(not(isEnabled())));
    }

    @And("pulsar boton {string}")
    public void pulsarBoton(String button) {

        int btn = button.equals("True") ? R.id.trueButton :  R.id.falseButton;
        onView(withId(btn)).perform(click());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
    }

    @And("mostrar resultado {string} a respuesta {string}")
    public void mostrarResultadoARespuesta(String result, String answer) {
        onView(withId(R.id.resultField)).check(matches(withText(result)));
    }

    @And("mostrar botones True y False y Cheat desactivados")
    public void mostrarBotonesTrueYFalseYCheatDesactivados() {
        onView(withId(R.id.trueButton)).check(matches(not(isEnabled())));
        onView(withId(R.id.falseButton)).check(matches(not(isEnabled())));
        onView(withId(R.id.cheatButton)).check(matches(not(isEnabled())));
    }

    @And("mostrar boton Next activado")
    public void mostrarBotonNextActivado() {
        onView(withId(R.id.nextButton)).check(matches(isEnabled()));
    }

    /*

    @When("girar pantalla")
    public void girarPantalla() {

        InstrumentationRegistry.getInstrumentation()
            .getUiAutomation().executeShellCommand("settings put system accelerometer_rotation 0");

        InstrumentationRegistry.getInstrumentation()
            .getUiAutomation().executeShellCommand("settings put system user_rotation 1");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }

        InstrumentationRegistry.getInstrumentation()
            .getUiAutomation().executeShellCommand("settings put system user_rotation 0");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
    }
    */

    @And("pulsar boton Cheat")
    public void pulsarBotonCheat() {
        onView(withId(R.id.cheatButton)).perform(click());
    }

    @And("iniciar pantalla Cheat")
    public void iniciarPantallaCheat() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
    }

    /*
    @And("mostrar mensaje Warning")
    public void mostrarMensajeWarning() {
        onView(withId(R.id.warningField)).check(matches(withText("Are you sure?")));
    }


    @And("ocultar respuesta")
    public void ocultarRespuesta() {
        onView(withId(R.id.answerField)).check(matches(withText("???")));
    }

    @And("mostrar botones Yes y No activados")
    public void mostrarBotonesYesYNoActivados() {
        onView(withId(R.id.yesButton)).check(matches(isEnabled()));
        onView(withId(R.id.noButton)).check(matches(isEnabled()));
    }
    */

    @And("pulsar boton Back")
    public void pulsarBotonBack() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }

        pressBack();
    }

    /*
    @And("pulsar boton No")
    public void pulsarBotonNo() {
        onView(withId(R.id.noButton)).perform(click());
    }
    */

    @And("finalizar pantalla Cheat")
    public void finalizarPantallaCheat() {

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
    }

    @And("resumir pantalla Question")
    public void resumirPantallaQuestion() {

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
    }

    /*
    @And("pulsar boton Yes")
    public void pulsarBotonYes() {
        onView(withId(R.id.yesButton)).perform(click());
    }

    @And("mostrar respuesta {string} a pregunta {string}")
    public void mostrarRespuestaAPregunta(String answer, String question) {
        onView(withId(R.id.answerField)).check(matches(withText(answer)));
    }

    @And("mostrar botones Yes y No desactivados")
    public void mostrarBotonesYesYNoDesactivados() {
        onView(withId(R.id.yesButton)).check(matches(not(isEnabled())));
        onView(withId(R.id.noButton)).check(matches(not(isEnabled())));
    }
    */

    @And("pulsar boton Next")
    public void pulsarBotonNext() {
        onView(withId(R.id.nextButton)).perform(click());
    }
}
