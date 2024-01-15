# DemonGame (MazeGame)

Welcome to DemonGame, the maze game developed by Group 3 for CMPT276.

## Overview

This repository contains the executable game file, `demonGame.jar`, and the associated Javadocs for ease of access.
The demonGame.jar file is located inside 276project/demonGame and the Javadocs are inside 276project/demonGame/target/site directory.

### Instructions:

_For the following Maven automations, ensure you are in the_ `276project/demonGame` _directory and have [Apache Maven installed](https://maven.apache.org/install.html)._

-   **Clean existing artifacts:** `mvn clean && del demonGame.jar`.
-   **Build the game:** `mvn package` to create the executable `demonGame.jar` in the `276project/demonGame` directory and the `target` folder.
-   **Run the game:** After building, execute `java -jar demonGame.jar`.
-   **Test the game:** Use `mvn test`.
-   **Create Javadocs:** Run `mvn site` to generate HTML files for Java code documentation.

_Note: To ensure proper loading of game graphics, call the game from the_ `276project/demonGame` _directory._

---

## Gameplay

![Gameplay Demo](/Documents/gif/game_demo.gif)

---

## UML Diagram

### Class Diagram

Here is the UML class diagram representing the key classes and their relationships in DemonGame:

![Class Diagram](/Documents/UML_Diagram_Final.png)

### Credits

-   [Regular reward (sprite)](https://graph.baidu.com/pcpage/similar?originSign=126f485bc504a85850d5401679107792&srcp=crs_pc_similar&tn=pc&idctag=gz&sids=1077595_1080051_1080824_1085874_1085752&gsid=&session_id=17316955970479476862&entrance=general&tpl_from=pc&pageFrom=graph_upload_pcshitu&inspire=general&image=http%3A%2F%2Fmms0.baidu.com%2Fit%2Fu%3D2317220067,749554139%26fm%3D253%26app%3D138%26f%3DPNG%3Fw%3D500%26h%3D500&carousel=503&index=3&page=3&shituToken=c17dbd)
-   [Trap (sprite)](https://graph.baidu.com/pcpage/similar?originSign=126571a9c48e4a5768c7d01679108091&srcp=crs_pc_similar&tn=pc&idctag=gz&sids=1077595_1080051_1080824_1085874_1085752&gsid=&session_id=8006947901671105024&entrance=general&tpl_from=pc&pageFrom=graph_upload_pcshitu&inspire=general&image=http%3A%2F%2Fmms2.baidu.com%2Fit%2Fu%3D2073939964,3501728953%26fm%3D253%26app%3D138%26f%3DJPEG%3Fw%3D300%26h%3D300&carousel=503&index=3&page=8&shituToken=a12e3e)
-   [Bonus reward (sprite)](https://www.bing.com/images/search?view=detailV2&insightstoken=bcid_T.dMyCkT-14FLe7.tqWoL2dmx8zY......4*ccid_90zIKRP7&form=SBIMSN&iss=VSI&sbisrc=ImgDropper&idpbck=1&sbifsz=150+x+150+%c2%b7+3.96+kB+%c2%b7+png&sbifnm=reward2.png&thw=150&thh=150&ptime=19&dlen=5412&expw=150&exph=150&selectedindex=30&id=6ECBCF271F1212054C12DDC548031593198E3977&ccid=90zIKRP7&vt=2&sim=1&pivotparams=insightsToken%3Dbcid_T.dMyCkT-14FqxcxoNWLuD9SqbotqVTdP34)
-   Remaining images/sprites: Royalty-free resources.

---
