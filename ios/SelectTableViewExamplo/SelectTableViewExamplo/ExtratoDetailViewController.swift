//
//  ExtratoDetailViewController.swift
//  SelectTableViewExamplo
//
//  Created by Adalberto Fernandes Junior on 24/06/17.
//  Copyright © 2017 Adalberto Fernandes Junior. All rights reserved.
//

import UIKit

class ExtratoDetailViewController: UIViewController {

    @IBOutlet weak var acaoLabel: UILabel!
    
    var extrato:String?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        

        // Do any additional setup after loading the view.
        
        if extrato != nil{
            acaoLabel.text = extrato
        }

    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
