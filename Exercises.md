# Lab 01 - Exercises
##### E26, E28-E30
##### John L. Carveth, 8645004
  
    
##### E26

|     | Simplicity of Code | Eff. When Creating Instances | Eff. when computing with both coords | Memory Used |
| --- |:------------------:|:----------------------------:|:------------------------------------:|:-----------:|
| d<sub>1</sub> | 2/5 - Flags not simple  |  3/5 - Lots of if-statements on init. | 2/5 - Coords constantly being calculated and flags switching. | 3/5 - More memory used per instance for flag. |
| d<sub>2</sub> | 4/5 - Few variables. Only calculate Cart. when needed. | 4/5 - Polar calculated on init. | 3/5 - Only one type of coord. needs to be calculated. | 4/5 - Only storing one type of coord and no flag. |
| d<sub>3</sub> | 4/5 - Few variables. Only calculate Polar when needed. | 4/5 - Cart. calculated on init. | 3/5 - Only one type of coord. needs to be calculated. | 4/5 - Only storing one type of coord and no flag. |
| d<sub>4</sub> | 4/5 - Many variables, less complicated methods. | 2/5 - Lots of calcluations and storage. | 4/5 - Both coords readily available. | 2/5 - Both coordinates stored. Lot's of memory. |
| d<sub>5</sub> | 5/5 - Abstraction simplifies code. | 5/5 - Each instance is perfect for use case. | 3/4 - Other type of coord needs to be calculated. | 5/5 - Only stores what is needed. |