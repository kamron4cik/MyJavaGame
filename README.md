# 🎮 2D Adventure Game

<div align="center">

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Swing](https://img.shields.io/badge/Swing-GUI-blue?style=for-the-badge)
![Game](https://img.shields.io/badge/Game-2D%20Adventure-green?style=for-the-badge)

*A classic 2D tile-based adventure game built with Java Swing*

</div>

## 📖 Overview

This is a 2D adventure game featuring a tile-based world where players can explore, collect items, and solve puzzles. The game includes character selection, collision detection, sound effects, and a complete game loop with smooth 60 FPS gameplay.

## ✨ Features

### 🎯 Core Gameplay
- **Tile-based Movement**: Smooth character movement across a grid-based world
- **Collision Detection**: Advanced collision system for walls, objects, and boundaries
- **Object Interaction**: Collect keys, open doors, find treasures, and discover medals
- **Character Selection**: Choose between boy and girl characters with unique sprites
- **Dynamic Character Switching**: Change characters during gameplay with the 'E' key

### 🎨 Visual Features
- **Sprite Animation**: Animated character sprites for all movement directions
- **Tile System**: Beautiful tile-based world with grass, walls, water, earth, trees, and sand
- **UI Elements**: Real-time display of collected keys, play time, and FPS counter
- **Victory Screen**: Congratulatory screen with play time statistics

### 🔊 Audio System
- **Background Music**: Immersive background soundtrack
- **Sound Effects**: Interactive sound effects for:
  - Key collection
  - Door opening/locking
  - Victory fanfare
  - Special medal collection (Despacito theme!)

### 🎮 Controls
- **WASD**: Movement (W=Up, S=Down, A=Left, D=Right)
- **E**: Switch between boy and girl characters

## 🏗️ Project Structure

```
src/
├── main/
│   ├── Main.java           # Application entry point
│   ├── GamePanel.java      # Main game loop and rendering
│   ├── KeyHandler.java     # Input handling
│   ├── UI.java            # User interface and HUD
│   ├── Sound.java         # Audio system
│   ├── StartScreen.java   # Character selection screen
│   ├── AssetSetter.java   # Game object placement
│   └── CollisionChecker.java # Collision detection system
├── entity/
│   ├── Entity.java        # Base entity class
│   └── Player.java        # Player character implementation
├── object/
│   ├── SuperObject.java   # Base object class
│   ├── KeyObject.java     # Collectible keys
│   ├── DoorObject.java    # Interactive doors
│   ├── ChestObject.java   # Treasure chest (victory condition)
│   └── MedalObject.java   # Special speed boost item
└── tile/
    ├── Tile.java          # Individual tile representation
    └── TileManager.java   # Tile system and map loading

res/
├── player/                # Character sprites
├── objects/               # Game object images
├── tiles/                 # Tile textures
├── sound/                 # Audio files
└── maps/                  # Level maps
```

## 🚀 Getting Started

### Prerequisites
- Java 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, etc.)

### Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd "Hospital finance"
   ```

2. **Open in your IDE**
   - Import the project as a Java project
   - Ensure the `res` folder is marked as a resource directory

3. **Run the game**
   ```bash
   java -cp src main.Main
   ```
   Or run `Main.java` from your IDE

## 🎯 How to Play

1. **Start the Game**: Run the application to see the character selection screen
2. **Choose Your Character**: Select between boy or girl character
3. **Explore the World**: Use WASD keys to move around the tile-based world
4. **Collect Items**:
   - 🗝️ **Keys**: Collect keys to open doors
   - 🚪 **Doors**: Use keys to unlock and pass through doors
   - 🏅 **Medal**: Special item that increases your speed and plays Despacito!
   - 📦 **Chest**: Find the treasure chest to win the game
5. **Switch Characters**: Press 'E' to switch between boy and girl characters anytime
6. **Win Condition**: Reach and interact with the treasure chest to complete the game

## 🎨 Game Objects

| Object | Description | Effect |
|--------|-------------|---------|
| 🗝️ Key | Collectible keys | Opens doors |
| 🚪 Door | Locked barriers | Requires keys to open |
| 🏅 Medal | Special power-up | Increases speed + plays Despacito |
| 📦 Chest | Treasure chest | Victory condition |

## 🔧 Technical Features

### Game Engine
- **60 FPS Game Loop**: Smooth gameplay with consistent frame rate
- **Delta Time Calculation**: Precise timing for animations and updates
- **Efficient Rendering**: Only renders visible tiles and objects for optimal performance

### Collision System
- **Tile Collision**: Prevents movement through walls and obstacles
- **Object Collision**: Handles interaction with collectible items
- **Boundary Detection**: Keeps player within the game world

### Audio System
- **Multiple Audio Channels**: Separate background music and sound effects
- **Dynamic Audio**: Context-sensitive sound effects for different actions

## 🎵 Sound Track

The game features an immersive audio experience:
- **Background Music**: "BlueBoyAdventure.wav"
- **Sound Effects**:
  - Coin collection sound
  - Door locking/unlocking sounds
  - Victory fanfare
  - Special Despacito theme for medal collection

## 🗺️ World Design

The game world is built using a tile-based system with:
- **Grass**: Basic walkable terrain
- **Walls**: Solid barriers that block movement
- **Water**: Decorative impassable terrain
- **Earth**: Alternative walkable terrain
- **Trees**: Natural obstacles
- **Sand**: Desert-themed walkable terrain

## 🔮 Future Enhancements

Potential improvements for future versions:
- Multiple levels/maps
- Enemy characters with AI
- Inventory system
- Save/load game functionality
- Multiplayer support
- More character types and animations
- Power-ups and special abilities
- Quest system

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request. For major changes, please open an issue first to discuss what you would like to change.

## 📝 License

This project is open source and available under the [MIT License](LICENSE).

## 🙏 Acknowledgments

- Inspired by classic 2D adventure games
- Built with Java Swing for cross-platform compatibility
- Tile-based game design principles
- Community feedback and suggestions

---

<div align="center">

**Enjoy your adventure! 🎮✨**

*Made with ❤️ and Java*

</div>