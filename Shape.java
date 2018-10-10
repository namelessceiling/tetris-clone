import java.util.Random;

public class Shape
{
    enum Tetrominos
    {
        NoShape(new int[][] {{0, 0}, {0, 0}, {0, 0}, {0, 0}}),
        ZShape(new int[][] {{0, -1}, {0, 0}, {-1, 0}, {-1, 1}}),
        SShape(new int[][] {{0, -1}, {0, 0}, {1, 0}, {1, 1}}),
        LineShape(new int[][] {{0, -1}, {0, 0}, {0, 1}, {0, 2}}),
        TShape(new int[][] {{-1, 0}, {0, 0}, {1, 0}, {0, 1}}),
        SquareShape(new int[][] {{0, 0}, {1, 0}, {0, 1}, {1, 1}}),
        LShape(new int[][] {{-1, -1}, {0, -1}, {0, 0}, {0, 1}}),
        MirroredLShape(new int[][] {{1, -1}, {0, -1}, {0, 0}, {0, 1}});

        private int[][] coords;

        private Tetrominos(int [][] coords)
        {
            this.coords = coords;
        }
    }
    private Tetrominos pieceShape;
    private int [][] coords;

    public Shape()
    {
        coords = new int[4][2];
        setShape(Tetrominos.NoShape);
    }

    public void setShape(Tetrominos shape)
    {
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 2; ++j)
            {
                coords[i][j] = shape.coords[i][j];
            }
        }
        pieceShape = shape;
    }

    private void setX(int index, int x)
    {
        coords[index][0] = x;
    }

    private void setY(int index, int y)
    {
        coords[index][1] = y;
    }

    private int x(int index)
    {
        return coords[index][0];
    }

    private int y(int index)
    {
        return coords[index][1];
    }

    public Tetrominos getShape()
    {
        return pieceShape;
    }

    public void setRandomShape()
    {
        Random random = new Random();
        int x = Math.abs(random.nextInt()) % 7 + 1;
        Tetrominos [] values =  Tetrominos.values();
        setShape(values[x]);
    }

    public int minX()
    {
        int min = coords[0][0];
        for(int i = 0; i < 4; i++)
        {
            min = Math.min(min, coords[i][0]);
        }
        return min;
    }

    public int minY()
    {
        int min = coords[0][1];
        for(int i = 0; i < 4; i++){
            min = Math.min(min, coords[i][1]);
        }
        return min;
    }
}
