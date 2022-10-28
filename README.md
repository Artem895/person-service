# person-service
<h1>Сообщение передается в message_analyzer(home_task_4) от туда попадает в common очередь , где считывается сервисом medical_monitoring(home_task_7) и распределяется в 3 очереди ,
из которых считывается person_service(home_task_7) и сохраняется в бд , так обновляется статус пациента </h1>

вид передоваемого сообщения через постман:
  Тип запроса:Post
  Адресс:http://localhost:8080/rabbit/send
  Тело: {
    "MessageType":"ERROR",
    "Message":"Hello from commone queue to daily queue от 28.10.22",
    "patient":"2",
    "helthstatus":"i"
}
