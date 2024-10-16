# Домашнее задание по теме "Retrofit Post"

## Приложение «Загрузчик картинок»

Необходимо написать приложение, в котором по нажатию на кнопку **«Загрузить»**, будет выполнен **GET** – запрос и получена картинка (фото) какого-нибудь животного, природы и тд. Рассматриваем закрепление темы получение информации из интернета (тема прошлого занятия). Для примера представляю ресурс для получения фото собак **baseUrl** = https://random.dog/

Зависимости для работы с библиотекой Glide для асинхронной подгрузки изображений из сети **_implementation_ ("com.github.bumptech.glide:glide:4.12.0") _annotationProcessor_ ("com.github.bumptech.glide:compiler:4.11.0")**

Функция запроса:

**@GET("woof.json?ref=apilist.fun") suspend fun getRandomDog(): ApiData**

Класс модели:

**data class ApiData(val fileSizeBytes: Int,     val url: String)**

Для работы приложения на экране необходимо создать:

1. **Toolbar** с заголовком.

2. Меню с пунктом выхода **«Exit»**.

3. **ImageView** для отображения загруженной картинки.

4. Кнопку **«Загрузить»** для загрузки рандомной картинки.

Можно рассмотреть и выполнить данную задачу, используя вариант загрузки других объектов (т.е. не предложенный выше).

Приложение необходимо сохранить проектом в удаленном репозитории, для проверки качества предоставить ссылку преподавателю, либо сделать скрины эмулятора при каждом шаге работы приложения или снять видео экрана при работе приложения.

## Скриншоты домашнего задания по теме "Retrofit Post"

<details>
<summary>Скриншоты</summary>

![](md/1.png)
![](md/2.png)
![](md/3.png)
![](md/4.png)

</details>