import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class HomeScreen extends StatelessWidget {
  const HomeScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Flutter Native View"),
        centerTitle: true,
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            ElevatedButton(onPressed: (){}, child: Text("Flutter view")),
            SizedBox(height: 50),
            Center(
              child: SizedBox(
                height: 100,
                child: AndroidView(viewType: "custom-button-view",
                  creationParams: <String, dynamic>{},
                  creationParamsCodec: StandardMessageCodec(),
                ),
              ),
            )
          ],
        ),
      ),
    );
  }
}
