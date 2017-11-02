/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interactiveproject.knightsimulator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ronny
 */
public class Board {
    private int rows;
    private int cols;
    public RealPlayer player;

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
    
    String[][] map;

    public String[][] getMap() {
        return map;
    }

    public Board() {
        
        try{
            //To remove Spaces in Path
            BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/interactiveproject/knightsimulator/level/2.txt")));
            String line;
            cols = Integer.valueOf(br.readLine());
            rows = Integer.valueOf(br.readLine());
            System.out.println(rows+" "+cols);
            map = new String[rows][cols];
            player  = new RealPlayer(this);
            for(int i=0;i<rows;i++)
            {
                line = br.readLine();
                for(int j=0;j<cols;j++)
                {
                    if(line.substring(j, j+1).equals("P"))
                    {
                        player.setY(i);
                        player.setX(j);
                        map[i][j] = ".";
                    }
                    else{
                        map[i][j] = line.substring(j, j+1);
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void draw(Graphics g, int width, int height)
    {
        g.setColor(Color.BLACK);
        int cellSize = Math.min(width/cols, height/rows);
        int offsetLeft = (width-cols*cellSize)/2;
        int offsetTop = (height - rows*cellSize)/2;
        for(int i=0;i<=rows;i++)
            g.drawLine(offsetLeft, offsetTop +  i*cellSize, offsetLeft+cols*cellSize, offsetTop +i*cellSize);
        for(int j=0;j<=cols;j++)
            g.drawLine(offsetLeft+j*cellSize,offsetTop, offsetLeft+j*cellSize, offsetTop +rows*cellSize);
        
        try {
            BufferedImage wall = ImageIO.read(getClass().getResourceAsStream("/interactiveproject/knightsimulator/images/wall red.png"));
            BufferedImage gold = ImageIO.read(getClass().getResourceAsStream("/interactiveproject/knightsimulator/images/gold.png"));
            for(int i=0; i<rows;i++)
                for(int j=0;j<cols;j++)
                {
                    if(map[i][j].equals("#"))
                    { 
                        g.drawImage(wall, offsetLeft+j*cellSize, offsetTop+i*cellSize, cellSize, cellSize, null);
                    }
                    else if(map[i][j].equals("x"))
                    {
                        g.drawImage(gold, offsetLeft+j*cellSize, offsetTop+i*cellSize, cellSize, cellSize, null);
                    }
                }
            if(player != null)
                player.draw(g, offsetLeft, offsetTop, cellSize);
            } catch (IOException ex) {
                Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}