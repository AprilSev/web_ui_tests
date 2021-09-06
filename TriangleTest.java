package ru.geekbrainsQA.DZ4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class TriangleTest {
    TriangleFunction triangleFunction = new TriangleFunction();

   // private static Logger logger = (Logger) LoggerFactory.getLogger(TriangleTest.class);

   // @BeforeEach
   // void beforeEach() {
   //     logger.info("Тестирование метода вычисления площади треугольника");
  //  }

    //С логером тесты не запускаются

    @Test
    void testCalcTriangleArea() throws NotTriangleException, NegativeSideOfTriangleException {
        double area = TriangleFunction.areaOfATriangle(10,10,10);
        Assertions.assertEquals(43.30127018922193, area);
    }

    @Test
    void testWhenSideOfTriangleIsNegative(){

       assertThatExceptionOfType(NegativeSideOfTriangleException.class).isThrownBy(
                () -> TriangleFunction.areaOfATriangle(10, 10, -10)
        );
    }

    @Test
    void testWhenFigureIsNotTriangle(){
        assertThatExceptionOfType(NotTriangleException.class).isThrownBy(
                () -> TriangleFunction.areaOfATriangle(10,5,1)
        );
    }

}
