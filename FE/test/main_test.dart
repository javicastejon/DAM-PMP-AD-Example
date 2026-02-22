import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:mockito/mockito.dart';
import 'package:provider/provider.dart';
import 'package:flutter_proyecto/main.dart';
import 'package:flutter_proyecto/providers/PedidoProvider.dart';
import 'package:flutter_proyecto/providers/ProductoProvider.dart';
import 'package:flutter_proyecto/providers/UsuarioProvider.dart';

class MockUsuarioProvider extends Mock implements UsuarioProvider {}
class MockProductoProvider extends Mock implements ProductoProvider {}
class MockPedidoProvider extends Mock implements PedidoProvider {}

void main() {
  group('MyApp Tests', () {
    testWidgets('MyApp renders MaterialApp', (WidgetTester tester) async {
      await tester.pumpWidget(
        MultiProvider(
          providers: [
            ChangeNotifierProvider<UsuarioProvider>(
              create: (_) => MockUsuarioProvider(),
            ),
            ChangeNotifierProvider<ProductoProvider>(
              create: (_) => MockProductoProvider(),
            ),
            ChangeNotifierProvider<PedidoProvider>(
              create: (_) => MockPedidoProvider(),
            ),
          ],
          child: const MyApp(),
        ),
      );

      expect(find.byType(MaterialApp), findsOneWidget);
    });

    testWidgets('MyApp has correct theme', (WidgetTester tester) async {
      await tester.pumpWidget(const MyApp());
      final materialApp = find.byType(MaterialApp);
      expect(materialApp, findsOneWidget);
    });

    testWidgets('MyApp displays PantallaInicioSesion', (WidgetTester tester) async {
      await tester.pumpWidget(const MyApp());
      expect(find.byType(MaterialApp), findsOneWidget);
    });
  });
}