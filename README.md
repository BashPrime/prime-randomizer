# prime-randomizer

[![Build Status](https://travis-ci.org/etaylor8086/prime-randomizer.svg?branch=master)](https://travis-ci.org/etaylor8086/prime-randomizer)

This project currently randomizes Metroid Prime (support for Metroid Prime 2: Echoes to be added later) and is incomplete/a work-in-progress.

Right now, the randomizer currently generates a list of randomized locations and prints it to the console, although it does support both using a random seed as well as the user specifying their seed of choice.

## Common Commands

After unzipping the project, use `java -jar randomizer.jar` to run the randomizer.

### Run the randomizer with a random seed

`java -jar randomizer.jar`

### Run the randomizer with a custom seed

`java -jar randomizer.jar --seed <seed>`

### Display the randomizer usage

`java -jar randomizer.jar --help`

## Credits

* Claris for writing the original Metroid Prime randomizer, as well as inspiration.

* rekameohs for writing the Randomizer script.

* Interslice and his seed generator for Claris's randomizer/rekameoh's script

* Pwootage for inspiration and the tremendous amount of help. Using and viewing the prime-patcher project alone gave me the motivation to move forward with this project.
