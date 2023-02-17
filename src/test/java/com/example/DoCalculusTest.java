package com.example;

import com.example.cli.Calculus;
import com.example.usecases.DoOperations;
import org.junit.Test;

import java.util.List;

public class DoCalculusTest {
    DoOperations doOperations = new DoOperations();

    @Test
    public void testWithAdditions() {
        List<Integer> result = this.doOperations.handle(List.of(1, 2, 3, 4), Calculus.plus);

        assert result.size() == 7;
        assert result.get(0) == 1;
        assert result.get(1) == 2;
        assert result.get(2) == 3;
        assert result.get(3) == 3;
        assert result.get(4) == 6;
        assert result.get(5) == 4;
        assert result.get(6) == 10;
    }

    @Test
    public void testWithMultiplications() {
        List<Integer> result = this.doOperations.handle(List.of(1, 2, 3, 4), Calculus.multiply);

        assert result.size() == 7;
        assert result.get(0) == 1;
        assert result.get(1) == 2;
        assert result.get(2) == 2;
        assert result.get(3) == 3;
        assert result.get(4) == 6;
        assert result.get(5) == 4;
        assert result.get(6) == 24;
    }

    @Test
    public void testSubstractions() {
        List<Integer> result = this.doOperations.handle(List.of(1, 2, 3, 4), Calculus.minus);

        assert result.size() == 7;
        assert result.get(0) == 1;
        assert result.get(1) == 2;
        assert result.get(2) == -1;
        assert result.get(3) == 3;
        assert result.get(4) == -4;
        assert result.get(5) == 4;
        assert result.get(6) == -8;
    }
}
