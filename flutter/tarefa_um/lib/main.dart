import 'package:flutter/material.dart';

import './text_control.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
          appBar: AppBar(
            title: Text('Tarefa 1'),
          ),
          body: TextControl(
              'Qual o siginificado da vida, do universo e tudo mais?')),
    );
  }
}
