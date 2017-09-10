//
//  ViewController.m
//  ViewControllerAnimations
//
//  Created by Adalberto Fernandes Junior on 01/08/16.
//  Copyright © 2016 Adalberto Fernandes Junior. All rights reserved.
//

#import "ViewController.h"
#import "OpcoesControllerViewController.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (IBAction)showDissolve:(id)sender {
    [self mostrarControllerComAnimacao:UIModalTransitionStyleCrossDissolve];
}

- (IBAction)showPageCurl:(id)sender {
    [self mostrarControllerComAnimacao:UIModalTransitionStylePartialCurl];
}

- (IBAction)showVertical:(id)sender {
    [self mostrarControllerComAnimacao:UIModalTransitionStyleCoverVertical];
}

- (IBAction)showHorizontal:(id)sender {
    [self mostrarControllerComAnimacao:UIModalTransitionStyleFlipHorizontal];

}

-(void) mostrarControllerComAnimacao: (UIModalTransitionStyle) estilo{
    OpcoesControllerViewController *c = [[OpcoesControllerViewController alloc] init];
    
    c.modalTransitionStyle = estilo;
    
    [self presentViewController:c animated:YES completion:nil];
    
}

@end
