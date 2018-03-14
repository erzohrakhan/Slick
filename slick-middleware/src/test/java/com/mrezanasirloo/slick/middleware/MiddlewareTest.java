package com.mrezanasirloo.slick.middleware;

import com.google.testing.compile.JavaFileObjects;
import com.google.testing.compile.JavaSourcesSubjectFactory;

import org.junit.Test;

import java.util.Arrays;

import javax.tools.JavaFileObject;

import static com.google.common.truth.Truth.assertAbout;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class MiddlewareTest {
    @Test
    public void requestGeneric() throws Exception {
        JavaFileObject routerSource = JavaFileObjects.forResource("resources/RouterGeneric.java");
        JavaFileObject genSource = JavaFileObjects.forResource("resources/RouterGenericSlick.java");
        JavaFileObject middlewareSource = JavaFileObjects.forResource("resources/MiddlewareNoOp.java");
        JavaFileObject middlewareSource2 = JavaFileObjects.forResource("resources/MiddlewareNoOp2.java");

        assertAbout(JavaSourcesSubjectFactory.javaSources())
                .that(Arrays.asList(routerSource, middlewareSource, middlewareSource2))
                .processedWith(new MiddlewareProcessor())
                .compilesWithoutError()
                        .and()
                        .generatesSources(genSource);
    }

    @Test
    public void requestSimple() throws Exception {
        JavaFileObject routerSource = JavaFileObjects.forResource("resources/RouterSimple.java");
        JavaFileObject genSource = JavaFileObjects.forResource("resources/RouterSimpleSlick.java");
        JavaFileObject middlewareSource = JavaFileObjects.forResource("resources/MiddlewareNoOp.java");
        JavaFileObject middlewareSource2 = JavaFileObjects.forResource("resources/MiddlewareNoOp2.java");

        assertAbout(JavaSourcesSubjectFactory.javaSources())
                .that(Arrays.asList(routerSource, middlewareSource, middlewareSource2))
                .processedWith(new MiddlewareProcessor())
                .compilesWithoutError()
                .and()
                .generatesSources(genSource);
    }

    @Test
    public void requestRx() throws Exception {
        JavaFileObject routerSource = JavaFileObjects.forResource("resources/RouterRx.java");
        JavaFileObject genSource = JavaFileObjects.forResource("resources/RouterRxSlick.java");
        JavaFileObject middlewareSource = JavaFileObjects.forResource("resources/MiddlewareNoOp.java");
        JavaFileObject middlewareSource2 = JavaFileObjects.forResource("resources/MiddlewareNoOp2.java");

        assertAbout(JavaSourcesSubjectFactory.javaSources())
                .that(Arrays.asList(routerSource, middlewareSource, middlewareSource2))
                .processedWith(new MiddlewareProcessor())
                .compilesWithoutError()
                .and()
                .generatesSources(genSource);
    }
    @Test
    public void requestCompletable() throws Exception {
        JavaFileObject routerSource = JavaFileObjects.forResource("resources/RouterCompletable.java");
        JavaFileObject genSource = JavaFileObjects.forResource("resources/RouterCompletableSlick.java");
        JavaFileObject middlewareSource = JavaFileObjects.forResource("resources/MiddlewareNoOp.java");
        JavaFileObject middlewareSource2 = JavaFileObjects.forResource("resources/MiddlewareNoOp2.java");

        assertAbout(JavaSourcesSubjectFactory.javaSources())
                .that(Arrays.asList(routerSource, middlewareSource, middlewareSource2))
                .processedWith(new MiddlewareProcessor())
                .compilesWithoutError()
                .and()
                .generatesSources(genSource);
    }

    @Test
    public void middlewareDagger() throws Exception {
        JavaFileObject routerSource = JavaFileObjects.forResource("resources/RouterDagger.java");
        JavaFileObject genSource = JavaFileObjects.forResource("resources/RouterDaggerSlick.java");
        JavaFileObject middlewareSource = JavaFileObjects.forResource("resources/MiddlewareNoOp.java");

        assertAbout(JavaSourcesSubjectFactory.javaSources())
                .that(Arrays.asList(routerSource, middlewareSource))
                .processedWith(new MiddlewareProcessor())
                .compilesWithoutError()
                .and()
                .generatesSources(genSource);
    }

}