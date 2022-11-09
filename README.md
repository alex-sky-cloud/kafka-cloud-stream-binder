### Spring Cloud Stream

Здесь описывается пример использования **Spring Cloud Stream**, этот API
является верхнеуровневой абстракцией для работы с брокерами сообщений 
( **Kafka** или **RabbitMQ**), что позволяет работать с брокерами без особой
настройки. Идея этого проекта похожа на **Spring Data Jpa**, только **Spring Data Jpa**
является абстракцией для работы с базой данных.


После того, как кластер будет создан, создайте **2 Topic**:
- numbers (Topic 1 / Source topic) – исходная тема
- squares (Topic 2 / Sink topic) – тема, в которую будут стекаться данные


### Порядок запуска проектов:

- cloud-stream-consumer
- cloud-stream-processor
- cloud-stream-producer

* Порядок запуска определен для наглядности и поэтому не имеет значения.