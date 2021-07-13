package fred.exploregalore.util.math;

/**
 * Provides an array of coordinates for a series of concentric circles.<br>
 * The base set of coordinates for each circle was calculated
 * using the Circle MidPoint Algorithm. However, as the algorithm does not guarantee perfect concentricity - that is,
 * it does not guarantee that there will be no unfilled points between adjacent circles (of radius varying by one) -
 * manual inspection was also used fill in any points that were not filled in.
 */
public final class DiscreteCircle {
    public static final int[][][] POINTS;
    public static final int MAX_RADIUS;

    static {
        POINTS = new int[][][]
                {
                        {{0, 0}},
                        {{1, 0}, {0, -1}, {-1, 0}, {0, 1}, {1, 1}, {1, -1}, {-1, -1}, {-1, 1}},
                        {{2, 1}, {-1, -2}, {-2, -1}, {1, 2}, {-2, 0}, {0, 2}, {-2, 1}, {-1, 2}, {2, -1}, {1, -2}, {2, 0}, {0, -2}},
                        {{2, 2}, {-2, -2}, {-3, -1}, {1, 3}, {-3, 0}, {0, 3}, {-3, 1}, {-1, 3}, {-2, 2}, {3, -1}, {1, -3}, {2, -2}, {3, 0}, {0, -3}, {3, 1}, {-1, -3}},
                        {{3, 2}, {-2, -3}, {3, 3}, {-3, -3}, {-3, -2}, {2, 3}, {-4, -1}, {1, 4}, {-4, 0}, {0, 4}, {-4, 1}, {-1, 4}, {-3, 2}, {-2, 3}, {-3, 3}, {3, -3}, {4, -1}, {1, -4}, {3, -2}, {2, -3}, {4, 0}, {0, -4}, {4, 1}, {-1, -4}},
                        {{4, 3}, {-4, -3}, {2, 5}, {0, 5}, {-2, 5}, {-4, 3}, {5, -2}, {3, -4}, {5, -1}, {1, -5}, {5, 0}, {5, 1}, {-1, -5}, {5, 2}, {-3, -4}, {3, 4}, {-5, -2}, {-5, -1}, {1, 5}, {-5, 0}, {-5, 1}, {-1, 5}, {-5, 2}, {-3, 4}, {2, -5}, {4, -3}, {0, -5}, {-2, -5}, {2, 4}, {4, 2}, {-2, 4}, {4, -2}, {2, -4}, {-4, 2}, {-2, -4}, {-4, -2}},
                        {{4, 5}, {5, 4}, {-4, 5}, {5, -4}, {4, -5}, {-5, 4}, {-4, -5}, {-5, -4}, {4, 4}, {-4, -4}, {-6, -2}, {2, 6}, {-6, -1}, {-6, 0}, {0, 6}, {-6, 1}, {-6, 2}, {-2, 6}, {-4, 4}, {5, -3}, {3, -5}, {1, -6}, {-1, -6}, {5, 3}, {-3, -5}, {-5, -3}, {3, 5}, {1, 6}, {-1, 6}, {-5, 3}, {-3, 5}, {6, -2}, {2, -6}, {4, -4}, {6, -1}, {6, 0}, {0, -6}, {6, 1}, {6, 2}, {-2, -6}},
                        {{-6, -4}, {4, 6}, {-6, -3}, {2, 7}, {0, 7}, {-2, 7}, {-6, 3}, {-6, 4}, {-4, 6}, {5, -5}, {7, -2}, {3, -6}, {7, -1}, {1, -7}, {7, 0}, {7, 1}, {-1, -7}, {7, 2}, {-3, -6}, {5, 5}, {-5, -5}, {3, 6}, {-7, -2}, {-7, -1}, {1, 7}, {-7, 0}, {-7, 1}, {-1, 7}, {-7, 2}, {-3, 6}, {-5, 5}, {6, -4}, {4, -6}, {2, -7}, {6, -3}, {0, -7}, {-2, -7}, {6, 3}, {6, 4}, {-4, -6}},
                        {{6, 5}, {-6, -5}, {4, 7}, {-8, -2}, {2, 8}, {-8, -1}, {-8, 0}, {0, 8}, {-8, 1}, {-8, 2}, {-2, 8}, {-4, 7}, {-6, 5}, {7, -4}, {5, -6}, {7, -3}, {3, -7}, {1, -8}, {-1, -8}, {7, 3}, {-3, -7}, {7, 4}, {-5, -6}, {5, 6}, {-7, -4}, {-7, -3}, {3, 7}, {1, 8}, {-1, 8}, {-7, 3}, {-3, 7}, {-7, 4}, {-5, 6}, {4, -7}, {6, -5}, {8, -2}, {2, -8}, {8, -1}, {8, 0}, {0, -8}, {8, 1}, {8, 2}, {-2, -8}, {-4, -7}}
                };
        MAX_RADIUS = POINTS.length;
    }


    public int[] computeNextCoorCircleMidpointFirstOctant(int x, int y, int radius) {
        int possiblePointsComparedError = 2 * ((x * x + y * y - radius * radius) + (2 * y + 1)) + (1 - 2 * x);
        boolean decrementX = possiblePointsComparedError > 0;
        return decrementX ? new int[]{x - 1, y + 1} : new int[]{x, y + 1};
    }
}
