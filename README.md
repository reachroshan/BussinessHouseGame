# Business House Game

Before Running the application 
1. Place the input file in resources folder. 
2. The format of the file is 
`CellsPattern=J,H,L,H,E,L,H,L,H,J <<NEXT_LINE>>
 DiceOutput=2,2,1, 4,2,3, 4,1,3, 2,2,7, 4,7,2, 4,4,2, 2,2,2 <<NEXT_LINE>>
 Players=3`
 
 2 sample files(_Input1.txt_ and _Input2.txt_) are already placed for reference. 
 
  
Step1: run

`mvn clean install` 

Step2:

`mvn exec:java -Dexec.mainClass=com.evaluate.businesshouse.Main -Dexec.args="Input2.txt"` 

where Input2.txt is the input file with test data in the below format:
