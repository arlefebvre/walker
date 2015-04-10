package fr.alefebvre.walker.gameObject;

public abstract class Helper {

    public static int Clamp(int value, int min, int max) {
        if (value > max)
            return max;
        if (value < min)
            return min;
        return value;
    }
}
