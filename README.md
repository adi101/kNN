# kNN

An implementation of the k-Nearest Neighbors algorithm in Java.

## How it works

The algorithm goes through the following steps to classify an object given a data set:

* Calculates the Euclidean distance between the object and each observation in the dataset
* Finds the *k* nearest observations
* Assigns the most popular classification of those *k* observations to the object

## How to use it

Let's take Fisher's *Iris* data set:

| Sepal length | Sepal width | Petal length | Petal width | Species       | 
|--------------|-------------|--------------|-------------|---------------| 
| 5.1          | 3.5         | 1.4          | 0.2         | I. setosa     | 
| 4.9          | 3           | 1.4          | 0.2         | I. setosa     | 
| 7            | 3.2         | 4.7          | 1.4         | I. versicolor | 
| 6.4          | 3.2         | 4.5          | 1.5         | I. versicolor | 
| 6.3          | 3.3         | 6            | 2.5         | I. virginica  | 
| 5.8          | 2.7         | 5.1          | 1.9         | I. virginica  | 

First, we need to set each species to an integer in order to classify them, and then convert the data set into a nested integer array (in this case, I've set 1 to *setosa*, 2 to *versicolor*, and 3 to *virginica*):
```Java
int[][] a = {{1, 51, 35, 14, 02},
			 {1, 49, 30, 14, 02},
			 {2, 73, 20, 47, 14},
			 {2, 64, 32, 45, 15},
			 {3, 63, 33, 60, 25},
			 {3, 58, 27, 51, 19}}
```

Finally, we just initialize the kNN class with an object we want to classify, and print it's classification:

```Java
int[] b = {60, 20, 40, 10};

kNN knn = new kNN(a, b, 2);

System.out.println(knn.getClassify());
```

This outputs *2*, as expected.
