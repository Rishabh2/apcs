package towerdefense;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class World
{
    public static final int PATH = 0;

    public static final int GRASS = 1;

    private Space[][] grid;

    private int height;

    private int width;

    private int scale;

    private Space start;

    private Space end;


    // TODO: create the path from start to end

    public World( String path )
    {
        scale = 25;
        height = 0;
        StringBuilder input = new StringBuilder();
        try
        {
            Scanner scanner = new Scanner( new File( path ) );
            while ( scanner.hasNextLine() )
            {
                input.append( scanner.nextLine() );
                height++;
            }
            width = input.length() / height;
            scanner.close();
        }
        catch ( FileNotFoundException e )
        {
            e.printStackTrace();
        }
        if ( input.length() > 0 )
        {
            grid = new Space[width][height];
            Window.size( width * scale, height * scale );
            Window.setFrameRate( 100 );
            for ( int x = 0; x < width; x++ )
            {
                for ( int y = 0; y < height; y++ )
                {
                    Space newspace = new Space( x * scale + scale / 2, y
                        * scale + scale / 2 );
                    switch ( input.charAt( x + y * width ) )
                    {
                        case 'S':
                            newspace.setType( PATH );
                            start = newspace;
                            break;
                        case 'E':
                            newspace.setType( PATH );
                            end = newspace;
                            break;
                        case 'P':
                            newspace.setType( PATH );
                            break;
                        case '.':
                            newspace.setType( GRASS );
                            break;
                    }
                    grid[x][y] = newspace;
                }
            }
        }
    }


    /**
     * Get the start of the path
     * 
     * @return the start of the path
     */
    public Space getStart()
    {
        return start;
    }


    /**
     * Get the end of the path
     * 
     * @return the end of the path
     */
    public Space getEnd()
    {
        return end;
    }


    /**
     * Draw the world
     */
    public void draw()
    {
        Window.out.background( "white" );
        for ( int x = 0; x < width; x++ )
        {
            for ( int y = 0; y < width; y++ )
            {
                Space space = grid[x][y];
                if ( space.getType() == PATH )
                {
                    Window.out.color( "peach" );
                }
                else if ( space.getType() == GRASS )
                {
                    Window.out.color( "light green" );
                }

                Window.out.square( x * scale + scale / 2,
                    y * scale + scale / 2,
                    scale );
                if ( space.hasTower() )
                {
                    space.getTower().draw();
                }
            }
        }
        Window.frame();
    }
}
