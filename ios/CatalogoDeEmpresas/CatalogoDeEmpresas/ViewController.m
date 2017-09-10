//
//  ViewController.m
//  CatalogoDeEmpresas
//
//  Created by Adalberto Fernandes Junior on 29/07/16.
//  Copyright © 2016 Adalberto Fernandes Junior. All rights reserved.
//

#import "ViewController.h"
#import "Empresa.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
    self.avisoSucessoLabel.hidden = true;
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (IBAction)incrementadorAlterado:(id)sender {
    UIStepper *incrementador = (UIStepper *) sender;
    self.quantidadeField.text = [NSString stringWithFormat:@"%d",(int)incrementador.value];
    
}

- (void) salvaEmpresa:(Empresa *) novaEmpresa{
    if (!catalogo) {
        catalogo = [[NSMutableArray alloc] init];
    }
    
    [catalogo addObject:novaEmpresa];
    
}

-(void)mostrarCatalogo{
    NSLog(@"******* Listando todas empresas *******");
    for (Empresa *empresa in catalogo) {
        NSLog(@"A empresa %@ tem %d funcionario(s).",
              empresa.nome,
              empresa.quantidadeFuncionarios);
    }
}

- (IBAction)salvar:(id)sender {
    //Libera o teclado
    [self.nomeField resignFirstResponder];
    
    Empresa *e = [[Empresa alloc]init];
    e.nome = self.nomeField.text;
    e.quantidadeFuncionarios = [self.quantidadeField.text intValue];
    
    [self salvaEmpresa:e];
    [self mostrarCatalogo];
    
    self.avisoSucessoLabel.alpha = 0;

    [UIView animateWithDuration:1 animations:^{
        self.avisoSucessoLabel.hidden = NO;
        self.avisoSucessoLabel.alpha = 1;
        
    } completion:^(BOOL finished) {
            [UIView animateWithDuration:1 delay:2 options:0 animations:^{
                self.avisoSucessoLabel.alpha = 0;
            } completion:^(BOOL finalizado) {
                self.avisoSucessoLabel.hidden = YES;
            }];
        }];
}

@end
