package towerdefense;

public class Space
{

    private int x;

    private int y;

    private int type;

    private Tower tower;


    /**
     * @param x
     *            the x coordinate of the space
     * @param y
     *            the y coordinate of the space
     * @param type
     *            the type of the space
     */
    public Space( int x, int y )
    {
        this.x = x;
        this.y = y;
        this.tower = null;
    }


    /**
     * Set the type of the space
     * 
     * @param type
     *            the type
     */
    public void setType( int type )
    {
        this.type = type;
    }


    /**
     * Get the type of the space
     * 
     * @return the type of the space
     */
    public int getType()
    {
        return type;
    }


    /**
     * Get the x coordinate of the space
     * 
     * @return the x coordinate
     */
    public int getX()
    {
        return x;
    }


    /**
     * Get the y coordinate of the space
     * 
     * @return the y coordinate
     */
    public int getY()
    {
        return y;
    }


    /**
     * Set this space's tower
     * 
     * @param tower
     *            the tower
     */
    public void setTower( Tower tower )
    {
        this.tower = tower;
    }


    /**
     * Check if the space has a tower
     * 
     * @return if the space has a tower
     */
    public boolean hasTower()
    {
        return tower != null;
    }


    /**
     * Get the tower in this space
     * 
     * @return the tower
     */
    public Tower getTower()
    {
        return tower;
    }
}
