package com.example.cli;

import java.util.Objects;

public class ArgumentParsed {

    String filename;
    Calculus calculus;

    public ArgumentParsed(String filename, Calculus calculus) {
        this.filename = filename;
        this.calculus = calculus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArgumentParsed that = (ArgumentParsed) o;
        return Objects.equals(filename, that.filename) && calculus == that.calculus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(filename, calculus);
    }

    public String getFilename() {
        return filename;
    }

    public Calculus getCalculus() {
        return calculus;
    }
}
