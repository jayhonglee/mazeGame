package group3.demonGame;

import java.awt.Image;

/**
 * 
 * @author zeyoup
 * 
 */
public class BonusReward extends GameObj{
    private int points = 200;
    private int count=0;
    private Score score;
 /**
  * Creates the gameObj BonusReward by using the default size setting(50 w x 50 h).
  * The BR will disappear after some counts.
  * demon will get 200 points after get BR.
  * 
  * @param x X coordinate of BonusReward
  * @param y Y coordinate of BonusReward
  * @param ig image of BonusReward from image repo
  * @param gm GameManager
 */
    public BonusReward(int x, int y, Image ig, GameManager gm, Score score) {
        super(x, y, ig, gm);
        this.score = score;

        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true){
                    count++;
                    try {
                        Thread.sleep(1000);
                        System.out.println(count);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();

    }// set thread
 /**
  * Adding points to score when demon get the BonusReward.
  * After 10 counts, removing the BonusReward from the map.
  */
    public void getReward(){
//        this.gm.score += points;
          score.increaseScore(points);
    }

    @Override
    public void update() {
        if (count>=10)
        {
            gm.objList.remove(this);
        }
    }


}