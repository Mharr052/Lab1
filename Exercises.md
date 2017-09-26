# Lab 01 - Exercises
##### E26, E28-E30
##### John L. Carveth, 8645004
  
    
##### E26

|     | Simplicity of Code | Eff. When Creating Instances | Eff. when computing with both coords | Memory Used |
| --- |:------------------:|:----------------------------:|:------------------------------------:|:-----------:|
| D<sub>1</sub> | 2/5 - Flags not simple  |  3/5 - Lots of if-statements on init. | 2/5 - Coords constantly being calculated and flags switching. | 3/5 - More memory used per instance for flag. |
| D<sub>2</sub> | 4/5 - Few variables. Only calculate Cart. when needed. | 4/5 - Polar calculated on init. | 3/5 - Only one type of coord. needs to be calculated. | 4/5 - Only storing one type of coord and no flag. |
| D<sub>3</sub> | 4/5 - Few variables. Only calculate Polar when needed. | 4/5 - Cart. calculated on init. | 3/5 - Only one type of coord. needs to be calculated. | 4/5 - Only storing one type of coord and no flag. |
| D<sub>4</sub> | 4/5 - Many variables, less complicated methods. | 2/5 - Lots of calcluations and storage. | 4/5 - Both coords readily available. | 2/5 - Both coordinates stored. Lot's of memory. |
| D<sub>5</sub> | 5/5 - Abstraction simplifies code. | 5/5 - Each instance is perfect for use case. | 3/4 - Other type of coord needs to be calculated. | 5/5 - Only stores what is needed. |

##### E28 & E29 & E30
Using the `PointCPD1` class and it's internal `D1D5Test` class, a test was run on two different data sizes. This test consisted of creating two instances of `PointCP` and two instances of `PointCPD1` with random coordinates between 0-100, getting all of their X,Y,Rho, and Theta values, and rotating the points a random angle between 0deg and 180deg.  

When the test was ran on a sample size of `n=100,000,000`, the test ran in ~40s on D1, and ~38s on D5. With a larger sample size of `n = 250,000,000`, D1 ran in 113s while D5 ran in 106s. The larger data size shows D5 will run more and more efficiently than D1 as n increases. However, the efficiency between the two designs is only relevant when the datasize > 100 million. For example, at `n = 500,000,000`, D5 ran only 5% more efficiently than design 1. 

|                | D<sub>1</sub> | D<sub>5</sub>) |
| -------------- |:-------------:|:--------------:|
|n = 100,000,000 | 40s           | 38s            |
|n = 250,000,000 | 113s          | 106s           |
|n = 500,000,000 | 211s          | 201s           |
