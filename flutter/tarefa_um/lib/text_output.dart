import 'package:flutter/material.dart';

class TextOutput extends StatelessWidget {
  final String mensagem;

  TextOutput({this.mensagem});

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Text(mensagem);
  }
}
