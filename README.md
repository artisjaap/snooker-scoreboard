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

## next lessons
- *Lesson 10 - Front-end implement follow-match:* First basic implementation of the scoreboard 
- *Lesson 11 - Front-end remote control:* Implementing the remote controll
- *Lesson 12 - follow-match with websockets:* Automatic refresh scoreboard with websockets
 