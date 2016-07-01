package towerdefense;


public abstract class Tower
{
    private int x;

    private int y;


    public void draw( int size )
    {
        Window.out.color( "green" );
        Window.out.circle( x, y, size );
    }

    // TODO: Add more methods
}
