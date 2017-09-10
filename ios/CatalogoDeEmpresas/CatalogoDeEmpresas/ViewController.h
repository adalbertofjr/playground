//
//  ViewController.h
//  CatalogoDeEmpresas
//
//  Created by Adalberto Fernandes Junior on 29/07/16.
//  Copyright © 2016 Adalberto Fernandes Junior. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface ViewController : UIViewController{
    NSMutableArray *catalogo;
}

@property (weak, nonatomic) IBOutlet UITextField *nomeField;
@property (weak, nonatomic) IBOutlet UITextField *quantidadeField;
@property (weak, nonatomic) IBOutlet UILabel *avisoSucessoLabel;
- (IBAction)incrementadorAlterado:(id)sender;
- (IBAction)salvar:(id)sender;


@end