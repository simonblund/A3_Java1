# [insert name here] - The great adventure

## Game
- Navigate the dungeon using NSEW.
- Fight monsters.
- Find treasures.
- Drink potions.

## Development

- Object persistence?
    - Using persistent storage or generators on initialisation.
    - Could be DB or yaml.. I like yaml unless sqlite works..


  - Packages
    - game
        - game components
        -ex Room.java
    - repository
        - used for object persistance ex. RoomRep.java
    - test
        -tests
    - utils utilities...

Classes

GAME
- Player
    - name
    - health
    - backpack / armor / stuff like that
    - Path(?) / current Room

- Room
    - Name
    - Description
    - Difficulty
    - Monster (nullable)
    - Treasure (nullable)
    - Doors (?)

- Monster
    - Name
    - Description.
    - Weaknesses (?)
    - Health
    - Strength

- Treasures
    - Name -- potion of life, shield of cats, crossbow etc.
    - Description
    - Health //does the treasure have health effect?
    - Strength // does the treasure have strength effect?
- Map
    - ArrayList w. Rooms

REPOSITORY
- PlayerRepository (?)
- RoomRepository
- MonsterRepository
- WeaponsRepository