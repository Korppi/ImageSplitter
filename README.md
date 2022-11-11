# ImageSplitter

Split spritesheets into separate images.

## Features

- Splits single spritesheet image to multiple images based on given row and column count.

## How to use

Clone the repo and build .jar file. Then open terminal where .jar file is located and write following:

```
java -jar ImageSplitter.jar C:\pathToSpritesheet\spritesheet.png 2 6
```

The first parameter path to spritesheet. Second parameter means how many rows spritesheet has and third one is for how many columns there are. Running this command
splits all images to their own files in same folder where spritesheet is located.
