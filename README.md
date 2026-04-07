# CacheSchemes
This project is representing how a cache uses different schemes when it reaches capacity\
The cache uses many different schemes represented by different data structures and benchmarks them\

FIF (Furthest in future) is an unrealistic search method that "reads into the future" and knows the next needed information (used as a benchmark test)\
FIFO (First in first out) implements a queue where the oldest data leaves first\
LFU (Least frequently used) removes the item with the lowest access frequency\
LIFO (Last in first out) implements a stack where the most recently acquired data leave first\
LRU (Least recently used) removes the least recently accessed items first\

All these different schemes are tested against each other to show how the different datastructures interact

