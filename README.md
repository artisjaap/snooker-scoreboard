# snooker-scoreboard
Implementation of a snooker scoreboard inspired by gertronic scoreboards. This is work in progress!

As a snooker player you want to focus on the game and don't want to take care about calculating score difference and so on.
Electronic scoreboards are expensive for personal use so I came up with the idea to program a scoreboard inspired by gertronic.
Basically, you can see the score of both players, their high score, highest break and frames played.
The goal of this project that the scoreboard can be visualized on any device (computer screen, tablet, ...) and it should be 
remote controlled by any (other) device, tablet, smartphone, ...

The repository will be structured as a zero-to-hero approach: For every "lesson" a new branch will be created, lesson-1, lesson-2,...
There will be a lesson.txt file available and give you some hints on what should be programmed in that lesson (e.g. lesson 1 will be about 
creating a data model to save scores). The next lesson-x branch will contain a solution together with a new lesson.txt file.
The master will always contain the latest version

## getting started
1. clone this repository
2. checkout the first lesson branch (git checkout lesson-1)
3. in the tutorial folder in the root you will find the first lesson (002 - Lesson 1.txt)

## available lessons
- *Lesson 1 - A basic datamodel:* create a basic Hibernate datamodel to store match info
- *Lesson 2 - Create interactions:* Add some actions to create a new match, points of a match,...
- *Lesson 3 - Create current frame:* Now that we have a match, we need someting to keep track of the current frame (points, highest break, ...)
- *Lesson 4 - Some more interactions:* We add some more actions to interact with the current frame 
- *Lesson 5 - Behaviour testing:* In this lesson we add behavior tests using Cucumber 
- *Lesson 6 - Create a webcontroller:* Now that we have our actions, we create REST-endpoints to call the appropriate actions 
- *Lesson 7 - Add basic Spring security:* We want our application to run on a server and host different matches.
 For this we need security in such a way that the create of a match is the owner of the match.
- *Lesson 8 - Front-end mockup:* Here we start with a basic mockup in Angular 
- *Lesson 9 - Front-end implement new match:* The implementation of the "new match" form 
- *Lesson 10 - Front-end implement follow-match:* First basic implementation of the scoreboard 
- *Lesson 11 - Front-end remote control:* Implementing the remote control
- *Lesson 12 - Front-end fast login:* an url containing username/password for a match so that a remote control can 
easly be created
- *Lesson 13 - follow-match with websockets:* Automatic refresh scoreboard with websockets
- *Lesson 14 - finalize basic functionality:* Add missing functionality to the scoreboard like highest break, last break, ...

## how to use
A first working beta version is now included.
1. download te build/libs/snooker-scoreboard-0.0.1-SNAPSHOT.jar
2. run *java -jar snooker-scoreboard-0.0.1-SNAPSHOT.jar* to spinup the serve
3. open a browser on http://localhost:8080
4. create a new match
5. click the 'remote' link at the bottom to view the remote control
6. refresh this screen (known bug)
7. open another window on http://localhost:8080/follow-match/1 (where 1 is the number you find on the remote control)
8. when you hit the buttons on the remote control, the scoreboard should update
9. you can open a second registered remote control http://localhost:8080/remote-connect/user1/secret (again, the 1 here should match with the matchID)
10. alternativly, you can create a remote or follow-match on a remote device on the same network on http://**ip of the server**:8080/