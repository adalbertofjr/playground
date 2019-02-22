import 'package:flutter/material.dart';

import './text_output.dart';

class TextControl extends StatefulWidget {
  final String texto;

  TextControl(this.texto);

  @override
  State<StatefulWidget> createState() {
    return _TextControlState();
  }
}

class _TextControlState extends State<TextControl> {
  String _texto;

  @override
  void initState() {
    _texto = widget.texto;
  }

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Container(
      margin: EdgeInsets.all(10.0),
      child: Center(
        child: Column(
          children: <Widget>[
            TextOutput(mensagem: _texto),
            Container(
                margin: EdgeInsets.all(10.0),
                child: RaisedButton(
                  onPressed: () {
                    setState(() {
                      texto = '42';
                    });
                  },
                  child: Text('Resposta'),
                )),
          ],
        ),
      ),
    );
  }
}
