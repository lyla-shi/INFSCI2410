[INSTRUCTION]
import the projects into java environment. 
Then, put the token file in the data file folder. 
Then run the main method of java_web and java_text seperately.

>>>At first I use a map to store tokens in posting and the speed is really fast. (as we can see in the java_web project). 
However, this data structure takes so much memory that my computer cannot handle that.
Then I create another method to store the data in different blocks and when we read the index, we can read them seperately.
Considering the speed of merging the index will be much slower, I just choose to read them seperately to relatively improve the speed.
Actually, I highly recommand the index process can be put into the Hadoop using Map-Reduce method to increase the indexing speed.

[Output]
finish 30000 docs
finish 60000 docs
finish 90000 docs
finish 120000 docs
finish 150000 docs
finish 180000 docs
totaly document count:  198361
successful
index web corpus running time: 0.9811833333333333 min
 >> the token "acow" appeared in 3 documents and 3 times in total
      lists-108-11347927    186006         1
       lists-092-4113429    154964         1
       lists-092-3952951    154963         1
load index & retrieve running time: 0.04995 min

finish 30000 docs
index1 appended.
finish 60000 docs
finish 90000 docs
index2 appended.
finish 120000 docs
index3 appended.
finish 150000 docs
finish 180000 docs
index4 appended.
finish 210000 docs
finish 240000 docs
index5 appended.
finish 270000 docs
index6 appended.
finish 300000 docs
finish 330000 docs
index7 appended.
finish 360000 docs
finish 390000 docs
index8 appended.
finish 420000 docs
index9 appended.
finish 450000 docs
finish 480000 docs
index10 appended.
totaly document count:  503473
successful
index text corpus running time: 28.01351666666667 min
2
2
 >> the token "yhoo" appeared in 5 documents and 5 times in total
        NYT19990208.0397    291085         1
        NYT19990405.0253    313384         1
        NYT20000717.0201    477373         1
        NYT20000928.0343    503146         1
        NYT20000927.0406    502701         1
load index & retrieve running time: 0.021633333333333334 min