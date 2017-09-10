//
//  ViewController.swift
//  SelectTableViewExamplo
//
//  Created by Adalberto Fernandes Junior on 24/06/17.
//  Copyright © 2017 Adalberto Fernandes Junior. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITableViewDataSource, UITableViewDelegate {
    
    @IBOutlet weak var tableView: UITableView!
    var opcoes = Array<Opcoes>()

    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.tableView.dataSource = self
        self.tableView.delegate = self
        
        // Do any additional setup after loading the view, typically from a nib.
        opcoes.append(Opcoes(regra: "Extrato", segueAcao: "segueExtrato"))
        opcoes.append(Opcoes(regra: "Resgate", segueAcao: "segueResgate"))
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        
        return opcoes.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        let cell = self.tableView.dequeueReusableCell(withIdentifier: "cell")!
        
        cell.textLabel?.text = opcoes[indexPath.row].regra
        
        return cell
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        let opcaoSelecionada = opcoes[indexPath.row].segueAcao
        
        self.performSegue(withIdentifier: opcaoSelecionada, sender: self)
        
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if(segue.identifier == "segueExtrato"){
            let view = segue.destination as! ExtratoDetailViewController
            view.extrato = "Segue Extrato..."
        }
        
        if(segue.identifier == "segueResgate"){
            print()
            let view = segue.destination as! ResgateDetailViewController
            view.resgate = "Segue Resgate..."
        }
    }
}



class Opcoes{
    let regra:String
    let segueAcao:String
    
    init(regra:String, segueAcao:String) {
        self.regra = regra
        self.segueAcao = segueAcao
    }
}
