# Brain Tumor Detection Mobile Application..
## 1. Project Description
Diagnosing a brain tumor takes a long time and relies heavily on the radiologist’s abilities and experience. The amount of data that must be handled has increased dramatically as the number of patients has increased, making old procedures both costly and ineffective. Deep Learning (DL) approaches have recently been popular in developing automated systems capable of accurately diagnosing or segmenting brain tumors in less time. The proposed Brain Tumor Classification Model  in our project based on CNN,Where the disease can be detected through magnetic resonance imaging by showing the result of the output yes or no to the user and we want to confirm that it is considered a preliminary examination and the patient must be referred to the specialist doctor for other necessary examinations. Finally we hope it will be a useful project for users and developers.

## 2. Dataset
The dataset is "Brain Tumor Detection 2020 " It was obtained from Kaggle. The dataset contains 3 folders: yes, no and pred which contains 3060 Brain MRI Images .The folder yes contains 1500 Brain MRI Images that are tumorous.The folder no contains 1500 Brain MRI Images that are non-tumorous. The data was divided into 80% training and 20% testing while create model.
https://www.kaggle.com/datasets/ahmedhamada0/brain-tumor-detection 

## 3. Create a CNN model for brain tumor detection 
Basic steps adopted to build the model:

* 1-Import the required libraries and packages.
* 2-Upload dataset by google drive
* 3-Data Pre-processing 
* 4-Splitting the data for training and testing
* 5-Building a CNN model
* 6-Save the model as (model.h5)
* 7-Testing the model
* 8-Convert the trained model to (model.tflite) file to use it into (android studio ) as TensorFlow Lite.
### To directly access the model in the Colab platform through the link:https://colab.research.google.com/drive/1dGQsZS5RFcsfXSlwnR0n4cMwMWSqy6KI?usp=sharing

## 4. Method To Deploy trained model to android studio program
* We used TensorFlow Lite method to deploy model.
* TensorFlow Lite : is a set of tools that enables on-device machine learning by helping developers run their models on mobile, embedded, and edge devices. 
* So Import the "model.tflite" file into Android Studio embeds into the ML folder to use it into Android Studio environment

## 5. Run the Application

It can directly run the application and it will predict the given input from the previously trained model. The version used for the android studio is 17 with 8.0.1 as the Android Gradle Plugin Version. You may face some issues if the Android Gradle Plugin Version is less than that.

You may want to make sure that the TensorFlow is implemented to the dependencies in the build.gridl. If you do not find it write the following two lines in the dependencies. 

```bash 
implementation 'org.tensorflow:tensorflow-lite-support:0.1.0'
implementation 'org.tensorflow:tensorflow-lite-metadata:0.1.0'
```
 #### 🔷NOTE: for testing application select image from your device then click on predict button to get result ✅ .
 #### The image must as Magnetic resonance imaging(MRI) for brain such as images in dataset 🧠🩻
 
## 6. Languages
* Python to build the Model in CoLab platform.
* Java to build the App in Android Studio.
